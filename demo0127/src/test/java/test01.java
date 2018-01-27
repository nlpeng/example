package java;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class test01 {

    @Test
    public void test1() throws IOException {
        String str = "ceshi";
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sinkChannel = pipe.sink();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            sinkChannel.write(byteBuffer);
        }
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        sourceChannel.read(buffer);
    }
}
