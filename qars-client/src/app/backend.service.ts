import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class BackendService {
  titleUrl = "http://localhost:8080/pageTitles/2";

  constructor(private http: HttpClient) {}

  getPageTitle() {
    return this.http
      .get(`${this.titleUrl}`, {responseType: 'text'})
      .pipe(
        catchError((err) => {
          console.log(err);
          return of('404 Not Fround');
        })
      );
  }
}
