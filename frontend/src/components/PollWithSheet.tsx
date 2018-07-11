import { Button, createStyles, MobileStepper, Paper, Theme, Typography, withStyles } from '@material-ui/core'
import { KeyboardArrowLeft as Left, KeyboardArrowRight as Right } from '@material-ui/icons'
import * as React from 'react'
import SwipeableViews, { SpringConfig } from 'react-swipeable-views'

import { Payload, State } from '../interfaces';
import { AddAnswersAction } from '../usecases/sheets/actionCreator';

const styles = (theme: Theme) => createStyles({
  root: {
    marginTop: theme.spacing.unit * 1,
    flexGrow: 1,
  },
  header: {
    display: 'flex',
    alignItems: 'center',
    textAlign: 'center',
    height: 50,
    padding: theme.spacing.unit * 4,
    marginTop: 20,
    marginBottom: 20,
    backgroundColor: theme.palette.background.default,
  },
  actions: {
    alignItems: 'center',
    textAlign: 'center',
    padding: theme.spacing.unit * 1,
    marginBottom: theme.spacing.unit * 1,
    backgroundColor: theme.palette.background.default,
  },
  buttons: {
    margin: theme.spacing.unit * 1,
  }
})

interface Props {
  classes: any
  theme: Theme
  poll: State.Poll
  sheet: State.Sheet
  answers: Payload.Answers
  addAnswer: (payload: Payload.Answers) => void
  saveAnswers: () => Promise<AddAnswersAction>
}

interface S {
  currentIndex: number
}

class SwipeableTextMobileStepper extends React.Component<Props, S> {

  public state = {
    currentIndex: 0
  }

  public handleChangeIndex = (currentIndex: number) => {
    this.setState({ currentIndex })
  }

  public handleMoveBackward = () => {
    const minIndex = 0
    this.setState(prevState => ({
      currentIndex: Math.max(prevState.currentIndex - 1, minIndex)
    }))
  }

  public handleMoveForward = () => {
    const maxIndex = this.props.poll.questions.length - 1
    this.setState(prevState => ({
      currentIndex: Math.min(prevState.currentIndex + 1, maxIndex)
    }))
  }

  public handleAnswer = (value: boolean, index: number) => {
    this.props.addAnswer({
      pollCode: this.props.poll.code,
      answers: [
        { [index]: value }
      ]
    })
    this.handleMoveForward()
  }

  public handleAnswerYes = (index: number) => {
    this.handleAnswer(true, index)
  }

  public handleAnswerNo = (index: number) => {
    this.handleAnswer(false, index)
  }

  public handleSaveAnswers = () => {
    this.setState({
      currentIndex: 0
    })
    this.props.saveAnswers()
  }

  public render() {
    const { currentIndex } = this.state
    const {
      poll = { questions: [] as string[] },
      sheet = {},
      classes
    } = this.props

    const questions = poll.questions.map((q, idx) => ({ idx, label: q }))

    const isAnswerNo = (index: number) => sheet[index] === false
    const isAnswerYes = (index: number) => sheet[index] === true

    const canMoveBackward = currentIndex !== 0
    const canMoveForward = (currentIndex !== questions.length - 1) &&
      (isAnswerNo(currentIndex) || isAnswerYes(currentIndex))

    const missingAnswersCount = questions.length - Object.keys(this.props.sheet || []).length
    const canSaveAnswers = missingAnswersCount === 0
    const canShowSaveAnswers = (canSaveAnswers || currentIndex === questions.length - 1) &&
      (isAnswerNo(questions.length - 1) || isAnswerYes(questions.length - 1))

    const springConfig: SpringConfig = {
      duration: '0.0s', // 0.4s
      easeFunction: 'ease-in',
      delay: '0.0s' // 0.2s
    }

    return (
      < React.Fragment >
        <SwipeableViews
          axis='x'
          index={currentIndex}
          onChangeIndex={this.handleChangeIndex}
          disabled={!(isAnswerNo(currentIndex) || isAnswerYes(currentIndex))}
          className={classes.root}
          springConfig={springConfig}
          enableMouseEvents
        >
          {
            questions.map(question => (
              <React.Fragment key={question.idx}>
                <Paper square className={classes.header}>
                  <Typography variant='subheading'>{question.label}</Typography>
                </Paper>
                <Paper className={classes.actions}>
                  <Button variant={isAnswerNo(question.idx) ? 'contained' : 'outlined'}
                    color='primary' className={classes.buttons} size='large'
                    // tslint:disable-next-line:jsx-no-lambda
                    onClick={() => this.handleAnswerNo(question.idx)}
                  >
                    No
                  </Button>
                  <Button variant={isAnswerYes(question.idx) ? 'contained' : 'outlined'}
                    color='primary' className={classes.buttons} size='large'
                    // tslint:disable-next-line:jsx-no-lambda
                    onClick={() => this.handleAnswerYes(question.idx)}
                  >
                    Yes
                  </Button>
                </Paper>
              </React.Fragment>
            ))
          }
        </SwipeableViews>
        <MobileStepper
          steps={questions.length}
          position='static'
          activeStep={currentIndex}
          className={classes.mobileStepper}
          backButton={
            <Button
              onClick={this.handleMoveBackward}
              disabled={!canMoveBackward}
              size='small'
              children={<Left />}
            />
          }
          nextButton={
            <Button
              onClick={this.handleMoveForward}
              disabled={!canMoveForward}
              size='small'
              children={<Right />}
            />
          }
        />
        <Paper
          hidden={!canShowSaveAnswers}
          className={classes.actions}>
          {!canSaveAnswers &&
            <Typography color='error'>
              Fill {missingAnswersCount} missing answers
            </Typography>
          }
          <Button
            size='large'
            style={{ marginTop: 10 }}
            color='secondary'
            variant='contained'
            disabled={!canSaveAnswers}
            onClick={this.handleSaveAnswers}
          >
            Save Answers
          </Button>
        </Paper>
      </React.Fragment >
    )
  }
}

export const PollWithSheetComponent = withStyles(
  styles, { withTheme: true }
)<Partial<Props>>(SwipeableTextMobileStepper)
