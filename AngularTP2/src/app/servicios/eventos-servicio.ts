import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { Evento } from "../modelos/evento";

@Injectable()
export class EventosServicio {
  url: string = 'http://127.0.0.1:8001/eventos'

  constructor(private http: HttpClient){  }

  getEventos():Observable<Evento[]>{
    return this.http.get<Evento[]>(this.url)
  }

  createEvento(evento:Evento){
    this.http.post<Evento>(this.url,evento)
      .subscribe(
        (response) => {
          console.log('Evento created...')
          return response;
        },
        (error) =>{
          console.log('ERROR createEvent...')
          console.log(error)
        }
      )
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }

  static eventos: Evento[] = [
    {'nombre':'CCCCCosquín Rock 2022', 'lugar':'Aeroclub Santa María de Punilla', 'fecha':'02-10-2022'},
    {'nombre':'Arctic Monkeys en Argentina', 'lugar':'Hipódromo de San Isidro', 'fecha':'03-30-2022'},
    {'nombre':'Lollapalooza Argentina', 'lugar':'Hipódromo de San Isidro', 'fecha':'04-05-2022'},
    {'nombre':'Iron Maiden en Argentina', 'lugar':'Estadio Vélez Sársfield', 'fecha':'10-12-2022'}
  ]

}
