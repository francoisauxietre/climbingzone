import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

interface Location {
  latitude: string;
  longitude: string;
}

@Injectable({
  providedIn: 'root'
})
export class MapsService {

  constructor(private httpClient: HttpClient) { }

  getLocation() {
    return this.httpClient.get<Location>('http://api.ipapi.com/api/161.185.160.93?access_key=3f70df695376ae53abacb16e8bbfb54a');
  }

}
