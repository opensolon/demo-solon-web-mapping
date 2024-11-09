package features;

import com.example.demo.App;

import org.junit.jupiter.api.Test;

import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@SolonTest(App.class)
public class DemoTest extends HttpTester {
    @Test
    public void hello() throws IOException {
        assert path("/hello/hello?name=world").get().contains("world");
        assert path("/hello/hello?name=solon").get().contains("solon");
    }

    @Test
    public void rest() throws IOException {
        assert path("/rest?name=world").get().contains("world");
        assert path("/rest").data("name", "world").post().contains("world");
        assert path("/rest").data("name", "world").put().contains("world");
        assert path("/rest").data("name", "world").delete().contains("world");
        assert path("/rest").data("name", "world").patch().contains("world");
    }

    @Test
    public void rest2() throws IOException {
        assert path("/rest2?name=world").get().contains("world");
        assert path("/rest2").data("name", "world").post().contains("world");
        assert path("/rest2").data("name", "world").put().contains("world");
        assert path("/rest2").data("name", "world").delete().contains("world");
        assert path("/rest2").data("name", "world").patch().contains("world");
    }

    @Test
    public void param() throws IOException {
        assert path("/param/path/world").get().contains("world");
        assert path("/param/header").header("name", "world").get().contains("world");
        assert path("/param/cookie").cookie("name", "world").get().contains("world");
        assert path("/param/body").bodyOfTxt("world").post().contains("world");
    }

    @Test
    public void file() throws IOException {
        assert path("/file/upload")
                .data("file", "demo.json", new ByteArrayInputStream("{'name':'world'}".getBytes()), "text/json")
                .multipart(true)
                .post().contains("demo.json");

        assert path("/file/download").execAsCode("GET") == 200;
    }

    @Test
    public void multipart() throws IOException {
        assert path("/multipart/upload")
                .data("file", "demo.json", new ByteArrayInputStream("{'name':'world'}".getBytes()), "text/json")
                .multipart(true)
                .post().contains("demo.json");

        assert path("/multipart/form")
                .data("name", "world")
                .data("icon", "demo.json", new ByteArrayInputStream("{'name':'world'}".getBytes()), "text/json")
                .multipart(true)
                .post().contains("world - demo.json");

        assert path("/multipart/data")
                .data("name", "world")
                .data("icon", "demo.json")
                .multipart(true)
                .post().contains("world - demo.json");

        assert path("/multipart/data2")
                .data("name", "world")
                .data("icon", "demo.json")
                .multipart(true)
                .post().contains("world - demo.json");
    }
}