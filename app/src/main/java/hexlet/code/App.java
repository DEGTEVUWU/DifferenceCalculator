package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
//import java.math.BigInteger;
//import java.nio.file.Files;
//import java.security.MessageDigest;
import java.util.concurrent.Callable;
@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "App 1.0",
        description = "Compares two configuration files and shows a difference.")

class App implements Callable {
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    File files1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    File files2;
    @Override
    public String call() throws IOException {
        System.out.println(Differ.generate(files1, files2));
        return "Hello, world";
    }
    public static void main(String[] args) throws IOException {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

