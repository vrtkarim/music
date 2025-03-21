package com.vrtkarim.music.service;

import com.vrtkarim.music.entities.Data;
import com.vrtkarim.music.exceptions.FileError;
import com.vrtkarim.music.exceptions.UploadFailed;
import com.vrtkarim.music.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
public class ServiceImplementation implements MusicService{
    final MusicRepository musicRepository;

    public ServiceImplementation(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Data getData(){

        try {
            return musicRepository.getMusicData();
        }catch (Exception e){
            throw new FileError(e.getMessage()) ;
        }
    }

    @Override
    public byte[] getImage(){
        try {
            return musicRepository.getArtWork();
        }catch (Exception e){
            throw new FileError(e.getMessage()) ;
        }
    }

    @Override
    public void setData(Data data){
        try {
            musicRepository.setData(
                    data
            );
        }catch (Exception e){
            throw new UploadFailed(e.getMessage());
        }
    }

    @Override
    public void setArtwork(byte[] artwork, String name){
        try{
            musicRepository.setImage(artwork, name);
            musicRepository.setArtWork();
        }catch (Exception e){
            throw new UploadFailed(e.getMessage());
        }

    }

    @Override
    public void setMusic(byte[] bytes, String name) {
        musicRepository.setMusic(bytes,name);
    }

    @Override
    public byte[] getMusic() {
        return musicRepository.getMusic();
    }

    @Override
    public String getFileName() {
        return musicRepository.getFileName();
    }

    @Override
    public void setLyrics(String lyrics) {
        musicRepository.setLyrics(lyrics);
    }

    @Override
    public String getLyrics() {
        return musicRepository.getLyrics();
    }


}
