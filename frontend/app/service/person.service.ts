import {Injectable} from '@angular/core';

import {Person} from './../model/models';
import { Headers, Http,Response } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/Rx';

@Injectable()
export class PersonService {

    private heroesUrl = 'http://localhost:8080/rest/persons';  // URL to web api
    private heroeUrl = 'http://localhost:8080/rest/person/';  // URL to web api

    constructor(private http: Http) { }

    getPersons():Observable<Person[]> {
      return this.http.get(this.heroesUrl)
                      .map(this.extractData)
                      .catch(this.handleError);
    }


    private extractData(res: Response) {
      let body = res.json();
      console.error(body);
      return body || {};
    }

    private handleError (error: Response | any) {
      // In a real world app, we might use a remote logging infrastructure
      let errMsg: string;
      if (error instanceof Response) {
        const body = error.json() || '';
        const err = body.error || JSON.stringify(body);
        errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
      } else {
        errMsg = error.message ? error.message : error.toString();
      }
      console.error(errMsg);
      return Observable.throw(errMsg);
    }

    getPerson(id:number):Observable<Person>{
      return this.http.get(this.heroeUrl + "" + id)
                      .map(this.extractData)
                      .catch(this.handleError);
    }

}
