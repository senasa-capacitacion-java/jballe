import { Component, OnInit } from '@angular/core';
import { Evento } from '../modelos/evento';
import { EventosServicio } from '../servicios/eventos-servicio';

@Component({
  selector: 'app-eventos-ok',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent implements OnInit {

  eventos: Evento[] = []
  constructor() { }

  ngOnInit(): void {
    this.eventos = EventosServicio.eventos;
  }

}
