package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

@WebServlet(urlPatterns = "/chat")
public class MessageServlet extends HttpServlet{

	private Context context;
	private static final long serialVersionUID = 6093948662123015033L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String message = req.getParameter("question");
		if (message.isEmpty())  this.context = null;
		MessageResponse response = this.conversationAPI(message, context);
		Chat chat = new Chat();
		chat.addUserMessage(message);
		chat.addBotMessage(response.getOutput().getText().get(0));
		context = response.getContext();
		resp.setContentType("application/json");
		
		resp.getWriter().write(new Gson().toJson(chat.getChat()));
	}
	
		private MessageResponse conversationAPI(String input, Context context){
		Conversation service = new Conversation("2018-05-14");
		//service.setApiKey("duYeDMHQMeROhz0AF0tAv0-bmW9iBKcIkja3r91Ojevn");
		service.setUsernameAndPassword("ab62296f-452e-4b70-aa76-32a13fb3acb3", "pbaKMDeUHblp");
		InputData inputData = new InputData.Builder().text(input).build();
		MessageRequest newMessage = new MessageRequest();
		newMessage.setInput(inputData);
		String workspaceId = "9bf79b5b-23bf-4d41-a8e6-44e7b55a346c";
		
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(inputData).context(context).build();
		MessageResponse response = service. message(options).execute();
		return response;
	} 

}
