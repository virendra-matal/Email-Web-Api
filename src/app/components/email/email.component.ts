import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from 'src/app/service/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

  data={
    to:'',
    subject:'',
    message:''
  }

  flag=false;

  constructor(private email:EmailService, private snack:MatSnackBar) { }

  ngOnInit(): void {
  }

  doSubmit(){
    console.log("hii");
    console.log(this.data);

    this.flag=true;
    if (this.data.to==null|| this.data.to=='' || this.data.subject==null || this.data.subject=='' || this.data.message==null|| this.data.to=='') {
      this.snack.open('Fields cannot be Empty ...','ok');
      this.flag=false;
      return;
    }

    this.email.sendEmail(this.data).subscribe(
      response=>{
        console.log(response);
        this.flag=false;
        this.snack.open('Email sent Successfully!!!','Ok');
      },
      error=>{
        console.log(error);
        this.flag=false;
        this.snack.open('Oops! Something went wrong, Try again...','Ok')
      }
    );

  }
}
