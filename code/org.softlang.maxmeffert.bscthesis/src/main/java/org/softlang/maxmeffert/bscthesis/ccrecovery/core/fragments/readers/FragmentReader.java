package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.readers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris.IFragmentUriConverter;

import java.io.*;
import java.net.URI;
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

    private final IFragmentUriConverter fragmentUriConverter;

    public FragmentReader(IFragmentUriConverter fragmentUriConverter) {
        this.fragmentUriConverter = fragmentUriConverter;
    }

    @Override
    public String read(String contents, IFragmentPosition fragmentPosition) throws IOException {
        return read(new StringReader(contents), fragmentPosition);
    }

    @Override
    public String read(File file, IFragmentPosition fragmentPosition) throws IOException {
        return read(new FileReader(file), fragmentPosition);
    }

    @Override
    public String read(InputStream inputStream, IFragmentPosition fragmentPosition) throws IOException {
        return read(new InputStreamReader(inputStream), fragmentPosition);
    }

    @Override
    public String read(String contents, IFragment fragment) throws IOException {
        return read(contents, fragment.getPosition());
    }

    @Override
    public String read(File file, IFragment fragment) throws IOException {
        return read(file, fragment.getPosition());
    }

    @Override
    public String read(InputStream inputStream, IFragment fragment) throws IOException {
        return read(inputStream, fragment.getPosition());
    }

    @Override
    public String read(URI uri) throws IOException {
        return read(new File(uri), fragmentUriConverter.toFragmentPosition(uri));
    }


}
