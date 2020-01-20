import { Injectable, OnInit } from '@angular/core';
import { AngularFireDatabase, AngularFireObject } from '@angular/fire/database';
import { HttpService } from 'src/app/service/http.service';

@Injectable({
	providedIn: 'root'
})
export class ChatService implements OnInit {
	constructor(private db: AngularFireDatabase, private http: HttpService) {}

	ngOnInit() {}

	getMessagesList() {
		return this.db.object('Chat').valueChanges();
	}

	getMessages(user) {
		return this.db
			.list('Chat/' + user + '/messages', ref => {
				return ref.orderByChild('timeStamp');
			})
			.valueChanges();
	}

	getMessagesId(userID) {
		return this.db.object('Chat/' + userID + '/messages').valueChanges();
	}

	getUsersList(firebaseIds) {
		return this.http.apiPost('/users/search', { firebaseIds });
	}

	sendMessage(user, message, chatID) {
		const messageData = {
			senderID: user.id,
			messageBody: message,
			senderName: user.name,
			timeStamp: new Date().getTime()
		};
		const agentMeta = {
			name: user.name,
			new: true
		};
		const userMeta = {
			new: false
		};

		this.db.list(`Chat/${chatID}/messages`).push(messageData);
		this.db.database.ref(`Chat/${chatID}/meta-data/agent`).update(agentMeta);
		this.db.database.ref(`Chat/${chatID}/meta-data/user`).update(userMeta);
	}

	endConversation(chatID) {
		const agentMeta = {
			name: '',
			new: false
		};
		const userMeta = {
			new: false
		};
		this.db.database.ref(`Chat/${chatID}/meta-data/agent`).update(agentMeta);
		this.db.database.ref(`Chat/${chatID}/meta-data/user`).update(userMeta);
	}
}
