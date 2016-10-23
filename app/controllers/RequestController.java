package controllers;

import models.ConnectionRequest;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by lubuntu on 10/23/16.
 */
public class RequestController extends Controller {
    public Result sendRequest(Long sid, Long rid){
        if(sid==null|rid==null| User.find.byId(sid)==null|User.find.byId(rid)==null){
            return ok();
    }
    else {
            ConnectionRequest request = new ConnectionRequest();
            request.sender.id = sid;
            request.receiver.id = rid;
            request.status = ConnectionRequest.Status.WAITING;

            ConnectionRequest.db().insert(request);
        }
        return ok();
    }
    public Result acceptRequest(Long rid){
        if(rid==null|ConnectionRequest.find.byId(rid)==null){
            return ok();
        }
        else{
            ConnectionRequest request=ConnectionRequest.find.byId(rid);
            request.sender.connections.add(request.receiver);
            request.receiver.connections.add(request.sender);
            User.db().save(request.sender);
            User.db().save(request.receiver);
        }
        return ok();
    }
}
