import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  messageForm: FormGroup;
  submitted = false;
  success = false;

  // injection de dependance
  constructor(private formBuilder: FormBuilder) {
    this.messageForm = this.formBuilder.group({
      name: ['', Validators.required],
      message: ['', Validators.required]
    });

  }

  onSubmit() {
    this.submitted = true;
    if (this.messageForm.invalid) {
      console.log('faire l envoi du message');
      return;
    }
    this.success = true;
  }

  ngOnInit() {
  }

}
