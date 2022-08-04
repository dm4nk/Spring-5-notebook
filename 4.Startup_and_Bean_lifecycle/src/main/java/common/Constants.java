package common;

public interface Constants {
    String DEFAULT_NAME = "Eric Clapton";
    String SINGER_ONE = "singerOne";
    String SINGER_TWO = "singerTwo";
    String SINGER_THREE = "singerThree";
    String DESTRUCTIVE_BEAN = "destructiveBean";
    String FILE_PATH = "#{systemProperties['java.io.tmpdir']}#{systemProperties['file.separator']}test.txt";
}
