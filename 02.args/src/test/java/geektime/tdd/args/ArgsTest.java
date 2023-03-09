package geektime.tdd.args;

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
    public void should_parse_multi_options() {
        MultiOptions options = Args.parse(MultiOptions.class, "-l", "-p", "8080",
                "-d", "/usr/logs");

        assertTrue(options.logging());
        assertEquals(8080, options.port());
        assertEquals("/usr/logs", options.directory());

    }
    static record MultiOptions(@Option("l") boolean logging, @Option("p") int port,
                               @Option("d") String directory) {}

   @Test
   public void should_set_boolean_option_to_true_if_flag_present() {
        BooleanOption option = Args.parse(BooleanOption.class, "-l");
        assertTrue(option.looging());
    }

    @Test
    public void should_set_boolean_option_to_false_if_flag_present() {
        BooleanOption option = Args.parse(BooleanOption.class);
        assertFalse(option.looging());
    }

    static record BooleanOption(@Option("l")boolean looging){}


    //Integer -p 8080

    @Test
    public void should_parse_int_as_option_value() {
        IntOption option = Args.parse(IntOption.class, "-p", "8080");
        assertEquals(8080, option.port());
    }

    static record IntOption(@Option("p")int port) {}

    //  String -d /usr/logs
    @Test
    public void should_parse_stringF_as_option_value() {
        StringOption option = Args.parse(StringOption.class,  "-d", "/usr/logs");
        assertEquals("/usr/logs", option.directory());
    }

    static record StringOption(@Option("d")String directory) {}

//    @Test
//    @Disabled
//    public void should() {
//        Options optioin = Args.parse("l:b,p:d,d:s", "-l", "-p", "8080");
//        args.getBool("l");
//        args.getInt("p");
//
//        Options options = args.parse(Options.class, "-l", "-p", "8880", "-d", "/usr/logs");
//
//    }
//
//    static record Options(@Option("l") boolean loggin, @Option("p") int port, @Option("d") String directory) {}

//    @Test
//    public void should_set_optino_to_true_if_flag_present() {
//        BooleanOption option = Args.parse(BooleanOption.class, "-l");
//        assertTrue(option.logging());
//    }
//    static record BooleanOption(@Option("l")boolean logging){}



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
