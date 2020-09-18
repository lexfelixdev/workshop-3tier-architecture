import { Component, OnInit } from '@angular/core';
import { BackendService } from './backend.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'qars-client';

  constructor(private backend: BackendService){}

  ngOnInit(){
    this.backend.getPageTitle().subscribe(pageTitle => this.title = pageTitle);
    console.log(this.title);
  }
}
