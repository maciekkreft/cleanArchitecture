import * as React from 'react'
import { Header, Init, Navigation, PollsList, PollWithSheet } from '../containers'

export const InitScreen = () =>
  <Init />

export const PollListScreen = () =>
  <React.Fragment>
    <Header />
    <PollsList />
    <Navigation tab={0} />
  </React.Fragment>

export const PollScreen = () =>
  <React.Fragment>
    <Header />
    <PollWithSheet />
    <Navigation tab={0} />
  </React.Fragment>

export const ResultScreen = () =>
  <React.Fragment>
    <Header />
    <Navigation tab={1} />
  </React.Fragment>

export const ProgressScreen = () =>
  <React.Fragment>
    <Header />
    <Navigation tab={1} />
  </React.Fragment>