import React from "react";
import { useNavigate } from "react-router-dom";

export const Login: React.FC = () => {
    const navigate = useNavigate()

    return (
        <main>
            <div>
                <section>
                    <h1>Login</h1>
                </section>
                <form action="">
                    <input type="text" />
                    <input type="text" />
                    <button>
                        sign in
                    </button>
                    <button onClick={() => { navigate('/sign-up') }}>
                        sign up
                    </button>
                </form>
            </div>
        </main>
    )
}
