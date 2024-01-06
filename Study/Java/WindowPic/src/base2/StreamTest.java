package base2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author cc
 * @create 2023/12/06
 * @description
 */
public class StreamTest {
    public static void main(String[] args) throws IOException {
         Path path = Paths.get("src/base2/Test");
         String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
         Stream<String> words = Stream.of(contents.split("\\PL+"));
         show("words",words);
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song",song);

        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos",echos);

        Stream<Double> random = Stream.generate(Math::random);
        show("random",random);

        Stream<BigDecimal> integers = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE));

        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordAnotherWay",wordsAnotherWay);

        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        show("lines",lines);

        Iterable<Path> iterable = FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectories = StreamSupport.stream(iterable.spliterator(), false);
        show("rootDirectories",rootDirectories);

        Iterator<Path> iterator = Paths.get("src/base2/Test").iterator();
        Stream<Path> pathComponents = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
        show("pathComponents",pathComponents);
    }

    public static <T> void show(String title, Stream<T> stream){
        final int SIZE = 10;
        List<T> firstElement = stream
                .limit(SIZE + 1)
                .collect(Collectors.toList());
        System.out.println(title + "");
        for (int i = 0; i < firstElement.size(); i++) {
            if(i > 0){
                System.out.println(",");
            }
            if(i < SIZE){
                System.out.println(firstElement.get(i));
                try {
                    final PrintWriter hello = new PrintWriter("Hello");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("...");
            }
        }
        System.out.println();
    }
}
