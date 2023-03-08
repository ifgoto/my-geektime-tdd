package geektime.tdd.args;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {
    //-l -p 8080 -d /usr/logs

    // sad path

    // default path
    // - bool : false
    // - int :0
    // - string ""


    @Test
    public void should_set_optino_to_true_if_flag_present() {
        BooleanOption option = Args.parse(BooleanOption.class, "-l");
        assertTrue(option.logging());
    }
    static record BooleanOption(@Option("l")boolean logging){}

//    @Test
//    @Disabled
//    public void should() {
//        Args args = Args.parse("l:b:p:d,d:s", "-l", "-p", "8080", "-d", "/usr/logs");
//        args.getBool("l");
//        args.getInt("p");
//
//
////        Options options = Args.parse(Option.class, "-l", "p", "8080", "-d","/usr/logs");
////        options.logging();
////        options.port();
//    }

//    static record Option(@Option("l")boolean logging, @Option("p")int  port, @Option("d")String directory){}
}
