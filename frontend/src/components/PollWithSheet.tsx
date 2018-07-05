import {
  Button, createStyles, MobileStepper, Paper, Theme, Typography, withStyles
} from '@material-ui/core'
import { KeyboardArrowLeft, KeyboardArrowRight } from '@material-ui/icons'
import * as React from 'react'
import SwipeableViews from 'react-swipeable-views'
import { State } from '../interfaces';

const styles = (theme: Theme) => createStyles({
  root: {
    // maxWidth: 400,
    marginTop: theme.spacing.unit * 2,
    flexGrow: 1,
  },
  header: {
    display: 'flex',
    alignItems: 'center',
    textAlign: 'center',
    height: 50,
    padding: theme.spacing.unit * 4,
    marginBottom: 20,
    backgroundColor: theme.palette.background.default,
  },
  actions: {
    padding: theme.spacing.unit * 4,
    // margin: theme.spacing.unit * 4,
    textAlign: 'center',
  }
})

interface Props {
  classes: any
  theme: Theme
  poll: State.Poll
}

interface S {
  activeStep: number
}

class SwipeableTextMobileStepper extends React.Component<Props, S> {
  public state = {
    activeStep: 0,
  }

  public handleNext = () => {
    this.setState(prevState => ({
      activeStep: prevState.activeStep + 1,
    }))
  }

  public handleBack = () => {
    this.setState(prevState => ({
      activeStep: prevState.activeStep - 1,
    }))
  }

  public handleStepChange = (activeStep: number) => {
    this.setState({ activeStep })
  }

  public render() {
    const { classes, theme, poll } = this.props
    const { activeStep } = this.state

    const steps = poll.questions.map(q => ({ 'label': q }))
    const maxSteps = steps.length

    return (
      <div className={classes.root}>
        <SwipeableViews
          axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
          index={this.state.activeStep}
          onChangeIndex={this.handleStepChange}
          enableMouseEvents
        >
          {steps.map(step => (
            <React.Fragment key={step.label}>
              <Paper key={step.label} square elevation={0} className={classes.header}>
                <Typography variant="subheading">{step.label}</Typography>
              </Paper>
              <Paper className={classes.actions}>
                <Button variant="outlined" color="primary" onClick={this.handleNext}>No</Button>
                <Button variant="outlined" color="primary" onClick={this.handleNext}>Yes</Button>
              </Paper>
            </React.Fragment>
          ))}
        </SwipeableViews>
        <MobileStepper
          steps={maxSteps}
          position="static"
          activeStep={activeStep}
          className={classes.mobileStepper}
          backButton={
            <Button size="small" onClick={this.handleBack} disabled={activeStep === 0}>
              {theme.direction === 'rtl' ? <KeyboardArrowRight /> : <KeyboardArrowLeft />}
            </Button>
          }
          nextButton={
            <Button size="small" onClick={this.handleNext} disabled={activeStep === maxSteps - 1}>
              {theme.direction === 'rtl' ? <KeyboardArrowLeft /> : <KeyboardArrowRight />}
            </Button>
          }
        />
      </div>
    )
  }
}

export const PollWithSheetComponent = withStyles(
  styles, { withTheme: true }
)<Partial<Props>>(SwipeableTextMobileStepper)