import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {ChatService, Message} from '../../chat.service';
import { scan, mapTo } from 'rxjs/operators';

@Component({
  selector: 'app-chat-dialog',
  templateUrl: './chat-dialog.component.html',
  styleUrls: ['./chat-dialog.component.scss']
})
export class ChatDialogComponent implements OnInit {

  messages: Observable<Message[]>;
  formValue: string;

  constructor(public chat: ChatService) { }

  ngOnInit() {
    // appends to array after each new message is added to feedSource
 //ici j'ai fait pipe et .scan car l'autre methode etait deprecate
    this.messages = this.chat.conversation.asObservable()
      .pipe(
        scan((acc,val)=>acc+val,null)
      )
  }

  sendMessage() {
    this.chat.converse(this.formValue);
    this.formValue = '';
  }

}
