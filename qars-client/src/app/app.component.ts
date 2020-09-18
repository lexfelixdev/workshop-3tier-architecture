import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'QARS';

  constructor(private http: HttpClient){
    http.get(`http://localhost:8080/pageTitles/2`, {responseType: 'text'})
    .pipe(
      catchError((err) => {
        console.log(err);
        return of('404 Not Fround');
      })
    ).subscribe(pageTitle => this.title = pageTitle);
  }
}
