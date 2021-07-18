import { Component, OnInit } from '@angular/core';
import { Evento } from '../modelos/evento';
import { EventosServicio } from '../servicios/eventos-servicio';

@Component({
  selector: 'app-eventos-ok',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css'],
  providers: [EventosServicio]
})

export class EventosComponent implements OnInit {

  eventos: Evento[] = []
  constructor(private eventoServicio:EventosServicio) { }

  ngOnInit(): void {
    this.eventoServicio.getEventos().subscribe(evts => this.eventos = evts)
  }

}
