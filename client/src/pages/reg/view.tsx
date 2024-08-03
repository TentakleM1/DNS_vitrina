import React from "react";
import { useNavigate } from "react-router-dom";

export const Reg: React.FC = () => {
    const navigate = useNavigate()

    return (
        <main>
            <div>
                <section>
                    <h1>Registration</h1>
                </section>
                <form action="">
                    <input type="text" />
                    <input type="text" />
                    <button>
                        sign un
                    </button>
                    <button onClick={() => { navigate('/') }}>
                        sign in
                    </button>
                </form>
            </div>
        </main>
    )
}