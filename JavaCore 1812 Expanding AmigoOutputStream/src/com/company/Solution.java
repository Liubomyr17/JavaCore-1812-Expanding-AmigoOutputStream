package com.company;

/*
1812 Expanding AmigoOutputStream

Using the Wrapper (Decorator) design pattern, extend the functionality of AmigoOutputStream.
In the QuestionFileOutputStream class, when calling the close () method, the following functionality should be implemented:
1. Display the phrase "Do you really want to close the stream? D / N" in the console.
2. Read the line.
3. If the read line is "D", then close the stream.
4. If the read line is not equal to "D", then do not close the stream.

Requirements:
1. The AmigoOutputStream interface cannot be changed.
2. The QuestionFileOutputStream class must implement the AmigoOutputStream interface.
3. The QuestionFileOutputStream class must initialize in the constructor a field of type AmigoOutputStream.
4. All QuestionFileOutputStream methods must delegate their execution to the AmigoOutputStream object.
5. The close () method should ask the user "Do you really want to close the stream? D / N".
6. The close () method should close the stream only if it reads the answer "D" from the console.

 */

import com.sun.deploy.net.DownloadException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;


public class Solution {
    public static void main(String[] args) {

    }

    public interface AmigoOutputStream {
        void flush() throws IOException;
        void write(int b) throws IOException;
        void write(byte[] b) throws IOException;
        void write(byte[] b, int off, int len) throws IOException;
        void close() throws IOException;
    }
    public static class QuestionFileOutputStream implements AmigoOutputStream {
        AmigoOutputStream component;
        public QuestionFileOutputStream(AmigoOutputStream component) {
            this.component = component;
        }

        @Override
        public void flush() throws IOException {
            component.flush();
        }

        @Override
        public void write(int b) throws IOException {
            component.write(b);
        }

        @Override
        public void write(byte[] b) throws IOException {
            component.write(b);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            component.write(b,off,len);
        }

        @Override
        public void close() throws IOException {
            System.out.println("Do you really want to close the thread? Y/N");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            if (s.equals("D"))
                component.close();;
                reader.close();
        }
    }
}

