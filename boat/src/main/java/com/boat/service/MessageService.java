/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.service;


import com.boat.model.Message;
import com.boat.repository.MessageRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jquiroga
 */

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepository;
    
    public List<Message> getAll(){
        return (List<Message>) messageRepository.getAll();
    }
    public Optional <Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }
    public Message save(Message messages){
        if(messages.getIdMessage()==null){
            return messageRepository.save(messages);
        }
        else{
            Optional<Message> evt=messageRepository.getMessage(messages.getIdMessage());
            if(evt.isEmpty()){
                return messageRepository.save(messages);
            }
            else{
                return messages;
            }
        }
        }
    
}
