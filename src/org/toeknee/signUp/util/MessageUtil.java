package org.toeknee.signUp.util;

/**
 * Created by toeknee on 11/26/15.
 */

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.toeknee.signUp.message.resp.Article;
import org.toeknee.signUp.message.resp.ImageMessage;
import org.toeknee.signUp.message.resp.MusicMessage;
import org.toeknee.signUp.message.resp.NewsMessage;
import org.toeknee.signUp.message.resp.TextMessage;
import org.toeknee.signUp.message.resp.VideoMessage;
import org.toeknee.signUp.message.resp.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtil {
    // message type for request
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    public static final String REQ_MESSAGE_TYPE_SHORT_VIDEO = "shortvideo";
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    // event type
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public static final String EVENT_TYPE_SCAN = "SCAN";
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    public static final String EVENT_TYPE_CLICK = "CLICK";
    public static final String EVENT_TYPE_VIEW = "VIEW";

    // message type for response
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // add CDATA tags to XStream
                //  to avoid parsing illegal elements
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * parse the XML sent from weChat server
     *
     * @param request
     * @return map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // store the parse results in a hash map
        Map<String, String> map = new HashMap<String, String>();

        // get the input stream from request
        InputStream inputStream = request.getInputStream();
        // read the input stream using SAX reader
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // get the XML root element
        Element root = document.getRootElement();
        // get all the child nodes of root
        List<Element> elementList = root.elements();

        // traverse all the child nodes
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // release input stream source
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * convert text message to XML
     *
     * @param textMessage
     * @return xml
     */
    public static String messageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * convert image message to XML
     *
     * @param imageMessage
     * @return xml
     */
    public static String messageToXml(ImageMessage imageMessage) {
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }

    /**
     * convert voice message to XML
     *
     * @param voiceMessage
     * @return xml
     */
    public static String messageToXml(VoiceMessage voiceMessage) {
        xstream.alias("xml", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }

    /**
     * convert video message to XML
     *
     * @param videoMessage
     * @return xml
     */
    public static String messageToXml(VideoMessage videoMessage) {
        xstream.alias("xml", videoMessage.getClass());
        return xstream.toXML(videoMessage);
    }

    /**
     * convert music message to XML
     *
     * @param musicMessage
     * @return xml
     */
    public static String messageToXml(MusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }

    /**
     * convert news message to XML
     *
     * @param newsMessage
     * @return xml
     */
    public static String messageToXml(NewsMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);
    }
}