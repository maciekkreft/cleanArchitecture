import {
  Button, createStyles, MobileStepper, Paper, Theme, Typography, withStyles
} from '@material-ui/core'
import { KeyboardArrowLeft, KeyboardArrowRight } from '@material-ui/icons'
import * as React from 'react'
import SwipeableViews from 'react-swipeable-views'
import { Action, Payload, State } from '../interfaces';
import { PostAnswersAction } from '../usecases/sheets/actions';

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
  sheet: State.Sheet
  answers: Payload.Answers
  addAnswer: (payload: Action.AnswerPayload) => void
  saveAnswers: () => Promise<PostAnswersAction>
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

  public handleAnswer = (value: boolean) => {
    this.props.addAnswer({
      index: this.state.activeStep,
      pollCode: this.props.poll.code,
      value
    })
    if (this.state.activeStep < this.props.poll.questions.length - 1) {
      this.handleNext()
    }
  }

  public handleNo = () => {
    this.handleAnswer(false)
  }

  public handleYes = () => {
    this.handleAnswer(true)
  }

  public handleSaveAnswers = () => {
    this.props.saveAnswers()
  }

  public render() {
    const { classes, theme, poll, sheet } = this.props
    const { activeStep } = this.state

    const steps = poll ? poll.questions.map(q => ({ 'label': q })) : []
    const maxSteps = steps.length

    return (
      poll
        ? <div className={classes.root}>
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
                  <Button
                    variant={(sheet && sheet[activeStep] === false) ? 'contained' : 'outlined'}
                    color="primary" onClick={this.handleNo}>No</Button>
                  <Button
                    variant={(sheet && sheet[activeStep] === true) ? 'contained' : 'outlined'}
                    color="primary" onClick={this.handleYes}>Yes</Button>
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
          {
            activeStep === maxSteps - 1
            && <Paper className={classes.actions}>
              <Button color="secondary" variant="outlined" onClick={this.handleSaveAnswers}>
                Save and get results
              </Button>
            </Paper>
          }
        </div>
        : null
    )
  }
}

export const PollWithSheetComponent = withStyles(
  styles, { withTheme: true }
)<Partial<Props>>(SwipeableTextMobileStepper)