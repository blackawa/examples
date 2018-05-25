import React from 'react';
import {storiesOf} from '@storybook/react';
import SingleTextForm from "../../src/components/presentations/molecules/SingleTextForm";

storiesOf('molecules/SingleTextForm', module)
    .add('default', () => <SingleTextForm/>);