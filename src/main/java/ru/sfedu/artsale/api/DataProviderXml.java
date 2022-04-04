package ru.sfedu.artsale.api;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.artsale.Constants;
import ru.sfedu.artsale.model.Result;
import ru.sfedu.artsale.model.XmlWrapper;
import ru.sfedu.artsale.utils.ConfigurationUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviderXml extends FileDataProvider {

    public DataProviderXml() throws IOException {
        path = ConfigurationUtil.getConfigurationEntry(Constants.XML_PATH);
        extension = ".xml";
    }

    @Override
    protected <T> List<T> read(Class<T> type) {
        List<T> list = new ArrayList<>();
        try {
            File file = initFile(getName(type));
            if (file.length() > 0) {
                FileReader fileReader = new FileReader(file);
                XmlWrapper<T> xmlWrapper = new Persister().read(XmlWrapper.class, fileReader);
                if (xmlWrapper.getList() != null) list.addAll(xmlWrapper.getList());
                fileReader.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return list;
    }

    @Override
    protected <T> boolean write(List<T> list, Class<T> type, String methodName) {
        try {
            File file = initFile(getName(type));
            FileWriter fileWriter = new FileWriter(file);
            Serializer serializer = new Persister();
            serializer.write(new XmlWrapper<>(list), fileWriter);
            fileWriter.close();
        } catch (Exception e) {
            log.error(e.getMessage());
            sendLogs(methodName, list.size() > 0 ? list.get(list.size() - 1) : null, Result.ERROR);
            return false;
        }
        sendLogs(methodName, list.size() > 0 ? list.get(list.size() - 1) : null, Result.SUCCESS);
        return true;
    }
}