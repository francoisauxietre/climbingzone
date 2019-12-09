import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {File} from '../Model/File'

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  baseUrl : string = "fafa.com:8080/10000/";
  constructor(private http : HttpClient) { }

  public getRepo(path: string){
    return this.http.get<File[]>(this.baseUrl+"dir/"+path);
  }

  public deleteElement(path: string){
    return this.http.delete(this.baseUrl+path);
  }
}
