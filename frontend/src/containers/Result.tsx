import * as React from 'react'
import { connect } from 'react-redux'
import { match as Match, withRouter } from 'react-router-dom'
import { compose, Dispatch } from 'redux'

import { ResultComponent } from '../components'
import { ApiContext } from '../contexts'
import { Api, State } from '../interfaces'
import * as ResultActions from '../usecases/results/actionCreator'
import * as SupplementActions from '../usecases/supplements/actionCreator'

const mapStateToProps = (state: State.default): Partial<Props> => ({
  result: (pollCode, version) => state.results.byCodeAndVersion[pollCode + '-' + version],
  supplements: (pollCode) => {
    const poll = state.polls.byCode[pollCode] || { supplements: [] }
    return poll.supplements.map(c => state.supplements.byCode[c])
  }
})

const mapDispatchToProps = (dispatch: Dispatch): Partial<Props> => ({
  getResults: ResultActions.getResults(dispatch),
  getSupplements: SupplementActions.getSupplements(dispatch)
})

interface RouterProps {
  match: Match<{ code: string, version: number }>
  history: any
  location: any
}

interface Props {
  api: Api
  getResults: (api: Api) => Promise<ResultActions.GetResultsAction>
  getSupplements: (api: Api) => Promise<SupplementActions.GetSupplementsActions>
  result: (pollCode: string, version: number) => State.Result
  supplements: (pollCode: string) => [State.Supplement] | State.Supplement[]
}

export class Result extends React.Component<Props & RouterProps> {
  public componentDidMount() {
    this.props.getResults(this.props.api)
    this.props.getSupplements(this.props.api)
  }

  public render() {
    const { result, supplements } = this.props
    const { code, version } = this.props.match.params
    return <ResultComponent result={result(code, version)} supplements={supplements(code)} />
  }
}

const ResultWithApi = (props: Props & RouterProps) =>
  <ApiContext.Consumer>
    {(api: Api) => <Result api={api} {...props} />}
  </ApiContext.Consumer>

export const ResultContainer =
  compose(
    withRouter,
    connect(
      mapStateToProps,
      mapDispatchToProps
    )
  )(ResultWithApi)