import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  private url='http://localhost:8484'

  constructor(private http:HttpClient) { }

  sendEmail(data:any){
    return this.http.post(`${this.url}/sendmail`,data);
  }
}
