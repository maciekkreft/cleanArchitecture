import * as Actions from './actions'

export default (state: boolean = false, action: Actions.GetInitActions) => {
  switch (action.type) {
    case Actions.POST_INIT_RESPONSE:
      return true
    default:
      return state
  }
}