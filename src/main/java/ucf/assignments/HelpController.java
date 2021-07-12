package ucf.assignments;

import java.io.IOException;

public class HelpController {
    public void back() throws IOException {
        ViewChanger.newStage.close();
        ViewChanger.changeTo(View.MAIN);
    }
}
