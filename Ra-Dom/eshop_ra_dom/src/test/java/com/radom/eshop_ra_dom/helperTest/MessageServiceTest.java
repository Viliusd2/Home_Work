package com.radom.eshop_ra_dom.helperTest;

import com.radom.eshop_ra_dom.helper.MessageService;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {


    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private MessageService messageService;

    @Test
    void testGetMessage_WhenKeyIsNull_ThenThrowException(){
        //given
        final String key = null;

        Mockito.doThrow(NoSuchMessageException.class).when(messageSource)
                .getMessage(eq(key),any(),any(Locale.class));
        //when
        String message = messageService.getMessage(key);
        //then

        assertNotNull(message);
        assertEquals("", message);
    }
    @Test
    void testGetMessage_WhenKeyNotExists() {
        // given
        final String key = "messageKey";

        Mockito.doThrow(NoSuchMessageException.class).when(messageSource)
                .getMessage(eq(key), any(), any(Locale.class));

        // when
        String message = messageService.getMessage(key);

        // then
        assertNotNull(message);
        assertEquals("?" + key + "?", message);
    }
    @Test
    void testGetMessage_WhenKeyExists() {
        // given
        final String key = "messageKey";
        Mockito.when(
                messageSource.getMessage(eq(key), any(), any(Locale.class)
                )).thenReturn("messageValue");

        // when
        String message = messageService.getMessage(key);

        // then
        assertNotNull(message);
        assertEquals("messageValue", message);
    }
}
