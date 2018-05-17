import React from 'react';

import TextField from './TextField';
import PreviewField from './PreviewField';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      text: 'hello'
    };
  }

  onTextChange(text) {
    this.setState({text: text})
  }

  render() {
    return (
        <div>
          <TextField value={this.state.text} onChange={this.onTextChange.bind(this)}/>
          <PreviewField text={this.state.text}/>
        </div>
    )
  }
}

export default App;