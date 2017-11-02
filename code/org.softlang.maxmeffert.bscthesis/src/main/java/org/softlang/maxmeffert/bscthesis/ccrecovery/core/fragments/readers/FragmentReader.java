package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.readers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FragmentReader implements IFragmentReader {

    private static List<String> readLinesBuffered(BufferedReader reader, IFragmentPosition position) throws IOException {
        int skip = position.getStartLine() - 1;
        int limit = position.getStopLine() - position.getStartLine() + 1;
        return reader.lines()
                .skip(skip)
                .limit(limit)
                .collect(Collectors.toList());
    }

    private static String readBuffered(BufferedReader reader, IFragmentPosition position) throws IOException {

        List<String> lines = readLinesBuffered(reader, position);

        int indexOfFirstLine = 0;
        int indexOfLastLine = lines.size() - 1;

        String firstLine = lines.get(indexOfFirstLine);
        String lastLine = lines.get(indexOfLastLine);

        lines.set(indexOfFirstLine, firstLine.substring(position.getStartCharInLine(), lines.get(0).length()));
        lines.set(indexOfLastLine, lastLine.substring(0, position.getStopCharInLine()));

        return String.join(System.lineSeparator(), lines);
    }

    private static String read(Reader reader, IFragmentPosition position) throws IOException {
        return readBuffered(new BufferedReader(reader), position);
    }

    @Override
    public String read(String contents, IFragmentPosition position) throws IOException {
        return read(new StringReader(contents), position);
    }

    @Override
    public String read(File file, IFragmentPosition position) throws IOException {
        return read(new FileReader(file), position);
    }

    @Override
    public String read(InputStream inputStream, IFragmentPosition position) throws IOException {
        return read(new InputStreamReader(inputStream), position);
    }


}
