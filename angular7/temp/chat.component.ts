import { Component, OnInit } from '@angular/core';
import { ChatService } from './chat.service';

@Component({
	selector: 'app-chat',
	templateUrl: './chat.component.html',
	styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements OnInit {
	messagesList: any;
	searchableList = [];
	users: any;
	usersList = [];
	selectedUser: any;

	chatItem: any;
	agent: any;

	newChatComment: any;

	constructor(
		private chatService: ChatService,
	) {
		this.agent = JSON.parse(localStorage.getItem('user'));
	}

	ngOnInit() {
		this.getMessage().then(users => {
			this.showChat(this.usersList[0]);
		});
	}

	getMessage() {
		return new Promise((res, rej) => {
			this.loaderService.show();
			this.chatService.getMessagesList().subscribe(messagesList => {
				this.messagesList = messagesList;
				console.log('the message list: ', this.messagesList);
				this.usersList = Object.keys(this.messagesList).map(val => {
					return val;
				});
				this.chatService.getUsersList(this.usersList).subscribe(usr => {
					this.users = usr['data'];
					this.searchableList = usr['data'];
				});
				this.getChat(this.usersList[0]);
				res(this.usersList);
			});
		});
	}

	getLatestMessage(msg) {
		const indx = Object.keys(msg.messages)[Object.keys(msg.messages).length - 1];
		const lastMsg = msg.messages[indx];
		if (lastMsg.card) {
			return lastMsg.card.tourTitle;
		} else {
			return lastMsg.messageBody;
		}
	}

	getLatestMessageTime(msg) {
		const indx = Object.keys(msg.messages)[Object.keys(msg.messages).length - 1];
		const lastMsg = msg.messages[indx];
		return lastMsg.timeStamp;
	}

	showChat(user) {
		this.loaderService.show();
		this.chatService.getMessages(user).subscribe(messages => {
			this.chatItem = messages;
			Object.keys(this.chatItem).map(key => {});
			this.loaderService.hide();
		});
		setTimeout(() => {
			document.querySelector('.message-fixed-section').scroll(0, 99999);
		}, 100);
	}

	getChat(user) {
		this.selectedUser = user;
		this.loaderService.show();
		this.chatService.getMessagesId(user).subscribe(messages => {
			if (messages) {
				Object.keys(messages).map(key => {});
				// this.showChat(user);
				this.loaderService.hide();
			}
		});
	}

	filterItems(event) {
		const input = event.target.value;
		this.searchableList = this.users.filter(item => {
			if (item.name.toLowerCase().includes(input.toLowerCase())) {
				return item;
			}
		});
	}

	postMessage(commentForm) {
		const message = commentForm.value.chatComment;
		const user = {
			id: this.agent._id,
			name: this.agent.name
		};
		console.log(message, user, this.agent);
		this.chatService.sendMessage(user, message, this.selectedUser);
		commentForm.reset();
	}

	endConversation() {
		this.chatService.endConversation(this.selectedUser);
	}
}

// This also may contain some unused stuff in here for the chat - that is for Twilio Call.