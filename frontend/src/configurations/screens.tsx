import * as React from 'react'
import { Header, Init, Navigation, PollsList, PollWithSheet } from '../containers'

export const InitScreen = () =>
  <Init />

export const PollListScreen = () =>
  <React.Fragment>
    <Header />
    <PollsList />
    <Navigation />
  </React.Fragment>


export const PollScreen = () =>
  <React.Fragment>
    <Header />
    <PollWithSheet />
    <Navigation />
  </React.Fragment>