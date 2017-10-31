package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmenttexts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentPosition;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FragmentReader implements IFragmentReader {

    private static List<String> readLines(BufferedReader reader, IFragmentPosition position) throws IOException {
        int skip = position.getStartLine() - 1;
        int limit = position.getStopLine() - position.getStartLine() + 1;
        return reader.lines()
                .skip(skip)
                .limit(limit)
                .collect(Collectors.toList());
    }

    private static String read(BufferedReader reader, IFragmentPosition position) throws IOException {

        List<String> lines = readLines(reader, position);

        int indexOfFirstLine = 0;
        int indexOfLastLine = lines.size() - 1;

        String firstLine = lines.get(indexOfFirstLine);
        String lastLine = lines.get(indexOfLastLine);

        lines.set(indexOfFirstLine, firstLine.substring(position.getStartCharInLine(), lines.get(0).length()));
        lines.set(indexOfLastLine, lastLine.substring(0, position.getStopCharInLine()));

        return String.join(System.lineSeparator(), lines);
    }

    @Override
    public String read(String contents, IFragmentPosition position) throws IOException {
        return read(new BufferedReader(new StringReader(contents)), position);
    }

    @Override
    public String read(File file, IFragmentPosition position) throws IOException {
        return read(new BufferedReader(new FileReader(file)), position);
    }

    @Override
    public String read(InputStream inputStream, IFragmentPosition position) throws IOException {
        return read(new BufferedReader(new InputStreamReader(inputStream)), position);
    }


}
