import { Component, OnInit } from '@angular/core';
import {File} from '../../Model/File'
import {ApiService} from "../../Services/api.service";
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html'
})
export class ListComponent implements OnInit {
  files: File[];
  path = "";
  constructor(public apiService:ApiService) {
    this.files = [
      {filename : "src", directory : true},
      {filename : ".git", directory : true},
      {filename : "pom.xml", directory:false}


    ]



  }

  ngOnInit() {
    this.refresh();
  }

  onDelete(element: File) {
    this.apiService.deleteElement(this.path+element.filename).subscribe(
      data=> this.refresh()
    );
  }

  private refresh() {
    this.apiService.getRepo(this.path).subscribe(data=>{
      this.files = data;
    })
  }

  onClick(element: File) {
    if(element.directory) {
      this.path = this.path + element.filename + "/";
      this.refresh();
    } else {

    }
  }

  onUp() {

  }
}
