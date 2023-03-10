package geektime.tdd.args;

import java.util.List;

class StringOptionParse extends IntOptionParser{

    @Override

    protected Object parseValue(String value) {
        return String.valueOf(value);
    }
}
