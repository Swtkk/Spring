package com.swietlik.swietlik;

import com.swietlik.swietlik.controller.AlreadyExistException;
import com.swietlik.swietlik.controller.StreamersController;
import com.swietlik.swietlik.model.Streamer;
import com.swietlik.swietlik.service.StreamersDataBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class SwietlikApplicationTests {
	@Autowired
	private StreamersController streamerController;

	@MockBean
	private StreamersDataBase theDataBase;

	@Test
	public void testFindAll() {
		Streamer streamer = new Streamer();
		List<Streamer> streamerList = Arrays.asList(streamer);
		Mockito.when(theDataBase.findAllStreamers()).thenReturn(streamerList);
		assertEquals(streamerList, streamerController.findAll());
	}

	@Test
	public void testGetStreamer() {
		Streamer streamer = new Streamer();
		Mockito.when(theDataBase.getStreamerById(anyInt())).thenReturn(streamer);
		assertEquals(streamer, streamerController.getStreamer(1));
	}

	@Test
	public void testAddStreamer() throws AlreadyExistException {
		Streamer streamer = new Streamer();
		Mockito.when(theDataBase.addStr(streamer)).thenReturn(streamer);
//		assertEquals(streamer, streamerController.findAll());
	}

	@Test
	public void testUpdateStreamer() {
		Streamer streamer = new Streamer();
		Mockito.doNothing().when(theDataBase).updateStreamer(streamer);
		streamerController.updateStreamer(streamer);
		Mockito.verify(theDataBase, Mockito.times(1)).updateStreamer(streamer);
	}

	@Test
	public void testDeleteStreamer() {
		Mockito.doNothing().when(theDataBase).deleteStreamer(anyInt());
		streamerController.deleteStreamer(1);
		Mockito.verify(theDataBase, Mockito.times(1)).deleteStreamer(1);
	}

}
