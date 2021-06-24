import React from 'react';
import {BrowserRouter, Switch, Route, Redirect} from 'react-router-dom';
import Header from '../components/Header';
import AddCountry from '../components/AddCountry';
import CountryList from '../components/CountryList';
import useLocalStorage from '../hooks/useLocalStorage';
import EditCountry from "../components/EditCountry";
import CountriesContext from '../context/ContriesContext';


const AppRouter = () => {
    const [books, setBooks] = useLocalStorage('books', []);

    return (
        <BrowserRouter>
            <div>
                <Header />
                <div className="main-content">
                    <CountriesContext.Provider value={{ books, setBooks }}>
                        <Switch>
                            <Route component={CountryList} path="/" exact={true} />
                            <Route component={AddCountry} path="/add" />
                            <Route component={EditCountry} path="/edit/:id" />
                            <Route component={() => <Redirect to="/" />} />
                        </Switch>
                    </CountriesContext.Provider>
                </div>
            </div>
        </BrowserRouter>
    );
};

export default AppRouter;