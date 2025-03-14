package com.vrtkarim.music.service;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface MusicService {
    Map<String, String> getData(File file);
    byte[] getImage(File file);
    void setData(File file, Map<String, String> data);
    void setImage(File music, File image);
    void tryToRead(File file);

    Map<String,String> setNameExtension(String name);
    Map<String,String> getNameExtension();
    void setTempFile(byte[] data);


}
