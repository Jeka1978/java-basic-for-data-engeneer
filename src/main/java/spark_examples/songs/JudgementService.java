package spark_examples.songs;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import scala.Tuple2;

import java.io.Serializable;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@PropertySource("classpath:user.properties")
public class JudgementService implements Serializable {

    private transient JavaSparkContext sc;// = SparkHolder.getSc();

    @Value("${garbage}")
    private List<String> garbageWords; //= ClassLoader.getSystemResource("user.properties");

    public List<String> topX(String artistName, int x) {

        JavaRDD<String> lines = sc.textFile("data/songs/" + artistName + "/*");
        lines.map(String::toLowerCase)
                .flatMap(WordsUtil::getWords)
                .filter(word-> !this.garbageWords.contains(word))
                .mapToPair(word-> Tuple2.apply(word,1));


        // todo use getWords method from WordUtils
        return null;// todo finish this. dont forget to filter all garbage words from user.properties
    }

    public int commonPopularWords(String artist1, String artist2, int x) {
        return 0;
    }
}
