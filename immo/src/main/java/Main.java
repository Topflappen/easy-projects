import de.aisy.immo.gui.FrameNavigatorObservable;
import de.aisy.immo.gui.pages.LoginForm;
import de.aisy.immo.gui.MainFrameNavigator;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrameNavigator mainFrameNavigator = new MainFrameNavigator(800, 600);
                FrameNavigatorObservable.getInstance().pushPage(LoginForm.getInstance());
                mainFrameNavigator.setVisible(true);
            }
        });

    }


    /*


         WebClient webClient = new WebClient();

        HtmlPage htmlPage = webClient.getPage("http://www.immobilienscout24.de/sso/login.go");

        HtmlElement usernameField = htmlPage.getElementById("j_username");

        HtmlElement passwordField = htmlPage.getElementById("j_password");

        usernameField.type("test");
        passwordField.type("testi");

        List<HtmlElement> htmlElements = htmlPage.getElementsByTagName("input");

        HtmlElement button = null;

        for(HtmlElement element: htmlElements) {

            if(element.getAttribute("value").equals("Anmelden")) {
                button = element;
                break;
            }
        }

        if(button == null) {
            throw new RuntimeException("not found");
        }

        Page page = button.click();

        System.out.print(page.getWebResponse().getContentAsString());




    File file = new File("/home/topflappen/Java/lib/htmlunit-2.10/lib");

        File[] files = file.listFiles();

        String result = "";

        for(File child: files) {

            String filename = child.getName();

            result += "sh /home/topflappen/Programme/Anwendungen/apache-maven-2.2.1/bin/mvn install:install-file -Dfile="
                    +file.getPath()+"/"+filename
                    +" -DgroupId=htmlunit -DartifactId=" +
                    filename.substring(0,filename.lastIndexOf("-"))
                    +" -Dversion=2.10 -Dpackaging=jar"
                    +"\n";
        }

        result+="\n\n";

        for(File child: files) {

            result += "<dependency>\n";
            result += " <groupId>";
            result += "htmlunit";
            result += "</groupId>\n";
            result += " <artifactId>";
            result += child.getName().substring(0,child.getName().lastIndexOf("-"));
            result += "</artifactId>\n";
            result += " <version>";
            result += "2.10";
            result += "</version>\n";
            result += "</dependency>\n\n";

        }

        System.out.print(result);
     */

}
