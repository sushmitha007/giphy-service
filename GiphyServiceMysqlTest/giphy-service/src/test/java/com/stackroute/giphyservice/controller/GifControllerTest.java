package com.stackroute.giphyservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.giphyservice.domain.Gif;
import com.stackroute.giphyservice.exception.GifAlreadyExistsException;
import com.stackroute.giphyservice.exception.GifNotFoundException;
import com.stackroute.giphyservice.service.GifService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GifController.class)
public class GifControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GifService gifService;

    private Gif gif;
    private List<Gif> gifList;

    @Before
    public void setUp() {
        gifList = new ArrayList<>();
        gif = new Gif(10l,"gif123","gif","http:url","http:details","cheeseburger","awesome","user1","g","2018-10-11");
        gifList.add(gif);
        gif = new Gif(20l,"gif125","gif","http:url","http:details","burgerking","awesome","user2","g","2017-03-11");
        gifList.add(gif);

    }

    @After
    public void tearDown() {
        gif = null;
    }

    @Test
    public void testSaveGifSuccess() throws Exception{
        when(gifService.saveGifToWishList(any())).thenReturn(gif);
        mockMvc.perform(post("/api/v1/giphyservice/gif")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(gif)))
                .andExpect(status().isCreated())
                .andDo(print());

    }
    @Test
    public void testSaveGifFailure() throws  Exception {
        when(gifService.saveGifToWishList(any())).thenThrow(GifAlreadyExistsException.class);
        mockMvc.perform(post("/api/v1/giphyservice/gif")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(gif)))
                .andExpect(status().isConflict())
                .andDo(print());

    }
    @Test
    public void testUpdateCaptionSuccess() throws Exception {
        when(gifService.updateCaptionForGif((gif.getCaption()),(gif.getGifId()))).thenReturn(gif);
        mockMvc.perform(patch("/api/v1/giphyservice/gif/10?caption=updatedcaption")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(gif)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void testUpdateCaptionFailure() throws Exception {
        when(gifService.updateCaptionForGif((anyString()),anyLong())).thenThrow(GifNotFoundException.class);
        mockMvc.perform(patch("/api/v1/giphyservice/gif/10?caption=updatedcaption")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(gif)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
    @Test
    public void testDeleteGifSuccess() throws Exception {
        when(gifService.deleteGifFromWishList(gif.getGifId())).thenReturn(true);
        mockMvc.perform(delete("/api/v1/giphyservice/gif/10")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(gif)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void testDeleteGifFailure() throws Exception {
        when(gifService.deleteGifFromWishList(anyLong())).thenThrow(GifNotFoundException.class);
        mockMvc.perform(delete("/api/v1/giphyservice/gif/10")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(gif)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
    @Test
    public void testGetAllGifsSuccess() throws Exception {
        when(gifService.getAllGifsFromWishList()).thenReturn(gifList);
        mockMvc.perform(get("/api/v1/giphyservice/gifs")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(gif)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void testGetAllGifsFailure() throws Exception {
        when(gifService.getAllGifsFromWishList()).thenThrow(Exception.class);
        mockMvc.perform(get("/api/v1/giphyservice/gifs")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(gif)))
                .andExpect(status().isInternalServerError())
                .andDo(print());
    }




    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(ob);
            result = jsonContent;
        } catch(JsonProcessingException e) {
            result = "JSON processing error";
        }

        return result;
    }
}
